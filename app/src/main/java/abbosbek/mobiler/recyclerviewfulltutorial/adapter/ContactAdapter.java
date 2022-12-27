package abbosbek.mobiler.recyclerviewfulltutorial.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import abbosbek.mobiler.recyclerviewfulltutorial.databinding.ItemLayoutBinding;
import abbosbek.mobiler.recyclerviewfulltutorial.model.Contact;

public class ContactAdapter extends ListAdapter<Contact,ContactAdapter.ItemHolder> {

    private OnClickListener listener;

    public ContactAdapter(OnClickListener listener) {
        super(new MyDiffUtil());
        this.listener = listener;
    }


    @NonNull
    @Override
    public ContactAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemHolder myItemHolder = new ItemHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext())));

        return myItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ItemHolder holder, int position) {

        Contact contact = getItem(position);

        holder.binding.tvName.setText(contact.getName());
        holder.binding.tvPassword.setText(contact.getPassword());
        
        holder.itemView.setOnClickListener(view -> listener.onDelete(contact,position));

    }


    public static class ItemHolder extends RecyclerView.ViewHolder{

        ItemLayoutBinding binding;

        public ItemHolder(@NonNull ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnClickListener{
        void onDelete(Contact contact,int position);
    }

    public static class MyDiffUtil extends DiffUtil.ItemCallback<Contact>{

        @Override
        public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.getPassword().equals(newItem.getPassword());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.equals(newItem);
        }
    }
}
