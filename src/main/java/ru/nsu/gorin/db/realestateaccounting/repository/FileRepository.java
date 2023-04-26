package ru.nsu.gorin.db.realestateaccounting.repository;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.utils.exceptions.NoFileFoundException;

import java.io.InputStream;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileRepository {

    private final GridFsTemplate gridFsTemplate;
    private final MongoDatabaseFactory mongoDatabaseFactory;

    public ObjectId saveFile(InputStream inputStream, String fileName) {
        return gridFsTemplate.store(inputStream, fileName);
    }

    public GridFsResource getResource(ObjectId id) {
        Optional<GridFSFile> file = Optional.ofNullable(gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id))));
        if (file.isPresent()) {
            return new GridFsResource(file.get(), getGridFs().openDownloadStream(file.get().getObjectId()));
        }
        throw new NoFileFoundException("Нет файла с id: " + id.toHexString());
    }

    public GridFsResource getResource(String fileName) {
        Optional<GridFSFile> file = Optional.ofNullable(gridFsTemplate.findOne(new Query(Criteria.where("filename").is(fileName))));
        if (file.isPresent()) {
            return new GridFsResource(file.get(), getGridFs().openDownloadStream(file.get().getObjectId()));
        }
        throw new NoFileFoundException("Нет файла с fileName: " + fileName);
    }

    public void deleteFile(ObjectId id) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }

    private GridFSBucket getGridFs() {
        return GridFSBuckets.create(mongoDatabaseFactory.getMongoDatabase());
    }
}
