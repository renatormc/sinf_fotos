package go.sptc.sinf.sinffotos;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class PicsAdapter extends RecyclerView.Adapter<PicsAdapter.MyViewHolder> {
    private ArrayList<Pic> pics;


    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public ImageView image;

        public MyViewHolder(LinearLayout v) {
            super(v);
            name = v.findViewById(R.id.imageName);
            image = v.findViewById(R.id.image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PicsAdapter(ArrayList<Pic> pics) {
        this.pics = pics;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PicsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pics_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(pics.get(position).getName());
        holder.image.setImageBitmap(pics.get(position).getBitmap());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pics.size();
    }


}
