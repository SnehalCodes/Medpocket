package api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.presco_ipdo.R;

import java.util.List;

public class HosListpadeadap extends BaseAdapter {
    List<HospitalPade> hoslist;
    Context context;

    public HosListpadeadap(Context context, List<HospitalPade> hoslist) {
        this.context = context;
        this.hoslist=hoslist;
    }

    @Override
    public int getCount() {
        return hoslist !=null ? hoslist.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = LayoutInflater.from( context).inflate( R.layout.patientdeapi, viewGroup,false );

        TextView txtname = view2.findViewById( R.id.apitext );

        txtname.setText( hoslist.get( i ).getHospital_name() );

        return view2;
    }
}
