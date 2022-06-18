package com.example.sherpa.Model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sherpa.R;
import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {

    private List<University> universityList;
    private Context context;

    public UniversityAdapter(List<University> universityList, Context context){
        this.universityList = universityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_university,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (universityList.get(position).getDomains() != null){
            String domains = universityList.get(position).getDomains().toString().replace("[","").replace("]","");
            holder.txtDomains.setText(domains);
        } else {
            holder.txtDomains.setText("- - -");
        }
        if (universityList.get(position).getName() != null){
            holder.txtName.setText(universityList.get(position).getName());
        }else {
            holder.txtName.setText("- - -");
        }

        University university = universityList.get(position);
        holder.cvUniversity.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
            View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.universityinfo_dialog,null);

            TextView txtWebPages = dialogView.findViewById(R.id.txtWebPages);
            TextView txtStateProvince = dialogView.findViewById(R.id.txtStateProvince);
            TextView txtCountry = dialogView.findViewById(R.id.txtCountry);
            TextView txtAlphaTwoCode = dialogView.findViewById(R.id.txtAlphaTwoCode);

            if (university.getWebPages() != null){
                String webPages = university.getWebPages().toString().replace("[","").replace("]","");
                txtWebPages.setText(webPages);
            }else {
                txtWebPages.setText("- - -");
            }
            if (university.getStateProvince() != null){
                txtStateProvince.setText(university.getStateProvince());
            }else {
                txtStateProvince.setText("- - -");
            }
            if (university.getCountry() != null){
                txtCountry.setText(university.getCountry());
            }else {
                txtCountry.setText("- - -");
            }
            if (university.getAlphaTwoCode() != null){
                txtAlphaTwoCode.setText(university.getAlphaTwoCode());
            }else {
                txtAlphaTwoCode.setText("- - -");
            }

            builder.setView(dialogView);
            builder.setNegativeButton("Atrás", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cvUniversity;
        private TextView txtDomains;
        private TextView txtName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvUniversity = itemView.findViewById(R.id.cardUniversity);
            txtDomains = itemView.findViewById(R.id.txtDomains);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
