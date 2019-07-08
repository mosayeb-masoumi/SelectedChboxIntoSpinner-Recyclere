package com.example.test.mainactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test.App;
import com.example.test.R;
import java.util.List;

public class AdapterMainActivity extends RecyclerView.Adapter<AdapterMainActivity.ViewHolder> {

    private List<Model> modelname;
    Context context;

    public AdapterMainActivity(List<Model> modelname, Context context) {
        this.modelname = modelname;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterMainActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMainActivity.ViewHolder holder, int position) {

        Model model = modelname.get(position);
        holder.txt_name.setText(model.getName());


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(holder.checkBox.isChecked()){
                    App.arrayListStringSelected.add(model.getName());
                    App.arrayListIntegerSelected.add(position);
                    Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();



                }else if(!holder.checkBox.isChecked()){
                    App.arrayListStringSelected.remove(model.getName());
                    App.arrayListIntegerSelected.remove(position);
                }

            }
        });





    }

    @Override
    public int getItemCount() {
        return modelname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name=itemView.findViewById(R.id.row_name);
            checkBox=itemView.findViewById(R.id.chk);
        }
    }


    //return string
    public String getList() {
        StringBuilder list = new StringBuilder();
        if (App.arrayListStringSelected.size() > 0)
            for (String s : App.arrayListStringSelected) {
                list.append(s).append(",");
            }
        if (list.length() > 0)
            list.deleteCharAt(list.length() - 1);
        return list.toString();
    }




    // return integer
    public String getListInteger(){

        StringBuilder listPosition = new StringBuilder();
        if(App.arrayListIntegerSelected.size()>0){
            for(Integer s : App.arrayListIntegerSelected){
                listPosition.append(s).append(",");
            }
            if (listPosition.length() > 0)
                listPosition.deleteCharAt(listPosition.length() - 1);

        }
        return listPosition.toString();
    }

}
