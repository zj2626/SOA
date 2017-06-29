package common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zj on 2017/6/22.
 */
public class EasyUIDdataGridResult implements Serializable {
    private long total;
    private List rows;

    public EasyUIDdataGridResult() {
    }

    public EasyUIDdataGridResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
