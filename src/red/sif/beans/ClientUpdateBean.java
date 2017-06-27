package red.sif.beans;

/**
 * Created by XIAN. Yingda on 2017/6/27 19:12.
 */
public class ClientUpdateBean {
    private String aid;
    private String cid;
    private String cnickname;
    private String cname;
    private String cphone;
    private String cidnum;
    private String acdiscount;
    private String clocation;
    private String acprecharge;
    private String cage;
    private String acpremethod;
    private String cgender;
    private String cnote;

    @Override
    public String toString() {
        return "ClientUpdateBean{" +
                "aid='" + aid + '\'' +
                ", cid='" + cid + '\'' +
                ", cnickname='" + cnickname + '\'' +
                ", cname='" + cname + '\'' +
                ", cphone='" + cphone + '\'' +
                ", cidnum='" + cidnum + '\'' +
                ", acdiscount='" + acdiscount + '\'' +
                ", clocation='" + clocation + '\'' +
                ", acprecharge='" + acprecharge + '\'' +
                ", cage='" + cage + '\'' +
                ", acpremethod='" + acpremethod + '\'' +
                ", cgender='" + cgender + '\'' +
                ", cnote='" + cnote + '\'' +
                '}';
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
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

    public String getAcdiscount() {
        return acdiscount;
    }

    public void setAcdiscount(String acdiscount) {
        this.acdiscount = acdiscount;
    }

    public String getClocation() {
        return clocation;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation;
    }

    public String getAcprecharge() {
        return acprecharge;
    }

    public void setAcprecharge(String acprecharge) {
        this.acprecharge = acprecharge;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getAcpremethod() {
        return acpremethod;
    }

    public void setAcpremethod(String acpremethod) {
        this.acpremethod = acpremethod;
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
