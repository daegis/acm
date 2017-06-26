package red.sif.beans;

/**
 * Created by XIAN. Yingda on 2017/6/26 15:19.
 */
public class Client {
    private int cid;
    private String cnickname;
    private String cphone;
    private String cname;
    private String cidnum;
    private String clocation;
    private int cage;
    private String cgender;
    private String cnote;

    @Override
    public String toString() {
        return "Client{" +
                "cid=" + cid +
                ", cnickname='" + cnickname + '\'' +
                ", cphone='" + cphone + '\'' +
                ", cname='" + cname + '\'' +
                ", cidnum='" + cidnum + '\'' +
                ", clocation='" + clocation + '\'' +
                ", cage=" + cage +
                ", cgender='" + cgender + '\'' +
                ", cnote='" + cnote + '\'' +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCnickname() {
        return cnickname;
    }

    public void setCnickname(String cnickname) {
        this.cnickname = cnickname;
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

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCgender() {
        return cgender;
    }

    public void setCgender(String cgender) {
        this.cgender = cgender;
    }

    public String getCnote() {
        return cnote;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote;
    }
}
