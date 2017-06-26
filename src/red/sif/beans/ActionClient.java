package red.sif.beans;

/**
 * Created by XIAN. Yingda on 2017/6/26 21:12.
 */
public class ActionClient {
    private String cid;
    private String cnickname;
    private String cname;
    private String cphone;
    private String cidnum;
    private String clocation;
    private String cage;
    private String cgender;
    private String acorder;
    private String acdate;
    private String acprice;
    private String acdiscount;
    private String acprecharge;
    private String acpremethod;
    private String acisready;

    @Override
    public String toString() {
        return "ActionClient{" +
                "cid='" + cid + '\'' +
                ", cnickname='" + cnickname + '\'' +
                ", cname='" + cname + '\'' +
                ", cphone='" + cphone + '\'' +
                ", cidnum='" + cidnum + '\'' +
                ", clocation='" + clocation + '\'' +
                ", cage='" + cage + '\'' +
                ", cgender='" + cgender + '\'' +
                ", acorder='" + acorder + '\'' +
                ", acdate='" + acdate + '\'' +
                ", acprice='" + acprice + '\'' +
                ", acdiscount='" + acdiscount + '\'' +
                ", acprecharge='" + acprecharge + '\'' +
                ", acpremethod='" + acpremethod + '\'' +
                ", acisready='" + acisready + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCnickname() {
        return cnickname;
    }

    public void setCnickname(String cnickname) {
        this.cnickname = cnickname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCidnum() {
        return cidnum;
    }

    public void setCidnum(String cidnum) {
        this.cidnum = cidnum;
    }

    public String getClocation() {
        return clocation;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getCgender() {
        return cgender;
    }

    public void setCgender(String cgender) {
        this.cgender = cgender;
    }

    public String getAcorder() {
        return acorder;
    }

    public void setAcorder(String acorder) {
        this.acorder = acorder;
    }

    public String getAcdate() {
        return acdate;
    }

    public void setAcdate(String acdate) {
        this.acdate = acdate;
    }

    public String getAcprice() {
        return acprice;
    }

    public void setAcprice(String acprice) {
        this.acprice = acprice;
    }

    public String getAcdiscount() {
        return acdiscount;
    }

    public void setAcdiscount(String acdiscount) {
        this.acdiscount = acdiscount;
    }

    public String getAcprecharge() {
        return acprecharge;
    }

    public void setAcprecharge(String acprecharge) {
        this.acprecharge = acprecharge;
    }

    public String getAcpremethod() {
        return acpremethod;
    }

    public void setAcpremethod(String acpremethod) {
        this.acpremethod = acpremethod;
    }

    public String getAcisready() {
        return acisready;
    }

    public void setAcisready(String acisready) {
        this.acisready = acisready;
    }
}
