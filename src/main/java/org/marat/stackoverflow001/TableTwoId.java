package org.marat.stackoverflow001;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TableTwoId implements Serializable {

    @Column(name = "SOME_STRING", insertable = false, updatable = false)
    private String someString;

    @Column(name = "SOME_INTEGER", insertable = false, updatable = false)
    private Integer someInteger;

    @Column(name = "SOME_INDEX", insertable = false, updatable = false)
    private Integer someIndex;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TableTwoId that = (TableTwoId) o;

        if (someString != null ? !someString.equals(that.someString) : that.someString != null) {
            return false;
        }
        if (someInteger != null ? !someInteger.equals(that.someInteger) : that.someInteger != null) {
            return false;
        }
        return someIndex != null ? someIndex.equals(that.someIndex) : that.someIndex == null;
    }

    @Override
    public int hashCode() {
        int result = someString != null ? someString.hashCode() : 0;
        result = 31 * result + (someInteger != null ? someInteger.hashCode() : 0);
        result = 31 * result + (someIndex != null ? someIndex.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TableTwoId{");
        sb.append("someString='").append(someString).append('\'');
        sb.append(", someInteger=").append(someInteger);
        sb.append(", someIndex=").append(someIndex);
        sb.append('}');
        return sb.toString();
    }
}
