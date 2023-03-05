package api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hospitallist_responsepatde {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("list")
    List<HospitalPade> hospitalList;

    public Hospitallist_responsepatde(String code, String msg, List<HospitalPade> hospitalList) {
        this.code = code;
        this.msg = msg;
        this.hospitalList = hospitalList;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<HospitalPade> getHospitalList() {
        return hospitalList;
    }
}

