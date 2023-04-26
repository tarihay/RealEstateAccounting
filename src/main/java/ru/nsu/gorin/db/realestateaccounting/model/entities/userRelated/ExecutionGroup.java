package ru.nsu.gorin.db.realestateaccounting.model.entities.userRelated;

import jakarta.persistence.*;
import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.Solution;

import java.util.List;

@Data
@Entity
@Table(name = "Execution_Group")
public class ExecutionGroup {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "type_of_work", nullable = false)
    private TypeOfWork typeOfWork;

    @ManyToMany(mappedBy = "executionGroups")
    private List<User> users;

    @OneToMany(mappedBy = "executor")
    private List<Solution> solutions;
}
