package common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zj on 2017/6/22.
 */
public class EasyUIDdataGridResult implements Serializable {
    private long tota;
    private List rows;

    public EasyUIDdataGridResult() {
    }

    public EasyUIDdataGridResult(long tota, List rows) {
        this.tota = tota;
        this.rows = rows;
    }

    public long getTota() {
        return tota;
    }

    public void setTota(long tota) {
        this.tota = tota;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
