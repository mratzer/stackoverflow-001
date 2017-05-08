package org.marat.stackoverflow001;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_TWO")
@IdClass(TableTwoId.class)
public class TableTwoEntity {

    @Id
    @Column(name = "SOME_STRING", insertable = false, updatable = false)
    private String someString;

    @Id
    @Column(name = "SOME_INTEGER", insertable = false, updatable = false)
    private Integer someInteger;

    @Id
    @Column(name = "SOME_INDEX", insertable = false, updatable = false)
    private Integer someIndex;

    @Column(name = "SOME_DATA")
    private String someData;

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
}
