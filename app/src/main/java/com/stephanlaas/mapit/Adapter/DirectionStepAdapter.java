package com.stephanlaas.mapit.Adapter;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stephanlaas.mapit.Fragments.HomeFragment;
import com.stephanlaas.mapit.Model.DirectionPlaceModel.DirectionStepModel;
import com.stephanlaas.mapit.databinding.StepItemLayoutBinding;

import java.text.DecimalFormat;
import java.util.List;

public class DirectionStepAdapter extends RecyclerView.Adapter<DirectionStepAdapter.ViewHolder> {

    private List<DirectionStepModel> directionStepModels;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        StepItemLayoutBinding binding = StepItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DecimalFormat df = new DecimalFormat("###.##");
        if (directionStepModels != null) {
            DirectionStepModel stepModel = directionStepModels.get(position);

            holder.binding.txtStepHtml.setText(Html.fromHtml(stepModel.getHtmlInstructions(), Html.FROM_HTML_MODE_LEGACY));

            holder.binding.txtStepTime.setText(stepModel.getDuration().getText());
            if (HomeFragment.systemVal.equals("true")){
                holder.binding.txtStepDistance.setText(stepModel.getDistance().getText());
            }else{
                double test = stepModel.getDistance().getValue();
                double newValue = test/1.609;
                holder.binding.txtStepDistance.setText(new DecimalFormat("#.##").format(newValue) + " yards");
            }
        }

    }

    @Override
    public int getItemCount() {

        if (directionStepModels != null)
            return directionStepModels.size();
        else
            return 0;
    }

    public void setDirectionStepModels(List<DirectionStepModel> directionStepModels) {
        this.directionStepModels = directionStepModels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private StepItemLayoutBinding binding;

        public ViewHolder(@NonNull StepItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}