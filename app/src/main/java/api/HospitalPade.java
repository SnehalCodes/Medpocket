package api;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalPade {
    @SerializedName("hospital_id")
    @Expose
    private String hospital_id;

    @SerializedName("hospital_name")
    @Expose
    private String hospital_name;

    public HospitalPade(String hospital_id, String hospital_name) {

        this.hospital_id = hospital_id;
        this.hospital_name = hospital_name;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}
