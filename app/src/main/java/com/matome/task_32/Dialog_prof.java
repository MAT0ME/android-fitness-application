package com.matome.task_32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Dialog_prof extends AppCompatDialogFragment {

    public String header_txt = "null";
    private EditText data_changed;
    private Dialog_prof_Listener listener;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        switch(dialog_text_helper.dialog_which_header){
            case 1 : header_txt = "Name"; break;
            case 2 : header_txt = "Last Name"; break;
            case 3 : header_txt = "Height";  break;
            case 4 : header_txt = "Weight"; break;
            case 5 : header_txt = "Age"; break;
            case 11: header_txt = "Target Height"; break;
            case 22: header_txt = "Target Weight"; break;
            case 33: header_txt = "Target Steps"; break; }





        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.pop_dialog, null);


        builder.setView(view)
                .setTitle(header_txt)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = data_changed.getText().toString();

                        listener.applyTexts(username);
                    }
                });

        data_changed = view.findViewById(R.id.dialog_input);


        return builder.create();
    }






    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (Dialog_prof_Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface Dialog_prof_Listener {
        void applyTexts(String username);
    }


    public void setHeader2(){


        switch(dialog_text_helper.dialog_which_header){
            case 1 : header_txt = "Name"; break;
            case 2 : header_txt = "Last Name"; break;
            case 3 : header_txt = "Height";  break;
            case 4 : header_txt = "Weight"; break;
            case 5 : header_txt = "Age"; break; }




    }

    public void setHeader3(){



        switch(dialog_text_helper.t_dialog_which_header){
            case 1: header_txt = "Target Height"; break;
            case 2: header_txt = "Target Weight"; break;
            case 3: header_txt = "Target Steps"; break; }


    }
}
