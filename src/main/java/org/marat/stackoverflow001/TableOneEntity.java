package org.marat.stackoverflow001;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_ONE")
@IdClass(TableOneId.class)
@NamedQueries({
        @NamedQuery(name = TableOneEntity.FIND_BY_SOME_DATA, query = "" +
                "SELECT one FROM TableOneEntity one " +
                "LEFT JOIN FETCH one.tableTwoEntity two " +
                "WHERE one.someData = :someData ")
})
public class TableOneEntity {

    public static final String FIND_BY_SOME_DATA = "one.findBySomething";

    @Id
    @Column(name = "SOME_STRING", insertable = false, updatable = false)
    private String someString;

    @Id
    @Column(name = "SOME_INTEGER", insertable = false, updatable = false)
    private Integer someInteger;

    @Id
    @Column(name = "SOME_INDEX", insertable = false, updatable = false)
    private Integer someIndex;

    @Column(name = "SOME_DATA", insertable = false, updatable = false)
    private String someData;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(name = "SOME_STRING", referencedColumnName = "SOME_STRING"),
            @JoinColumn(name = "SOME_INTEGER", referencedColumnName = "SOME_INTEGER"),
            @JoinColumn(name = "SOME_INDEX", referencedColumnName = "SOME_INDEX")
    })
    private TableTwoEntity tableTwoEntity;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public Integer getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    public Integer getSomeIndex() {
        return someIndex;
    }

    public void setSomeIndex(Integer someIndex) {
        this.someIndex = someIndex;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    public TableTwoEntity getTableTwoEntity() {
        return tableTwoEntity;
    }

    public void setTableTwoEntity(TableTwoEntity tableTwoEntity) {
        this.tableTwoEntity = tableTwoEntity;
    }

    // getters and setters



}
