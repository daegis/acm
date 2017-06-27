package red.sif.beans;

/**
 * Created by XIAN. Yingda on 2017/6/27 21:30.
 */
public class Location {
    private String provincename;
    private String cityname;
    private String districtname;

    @Override
    public String toString() {
        return provincename + cityname + districtname;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }
}
