package abbosbek.mobiler.recyclerviewfulltutorial.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import abbosbek.mobiler.recyclerviewfulltutorial.databinding.ItemLayoutBinding;
import abbosbek.mobiler.recyclerviewfulltutorial.model.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ItemHolder> {

    private List<Contact> contactList;

    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemHolder myItemHolder = new ItemHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext())));

        return myItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ItemHolder holder, int position) {
        holder.binding.tvName.setText(contactList.get(position).getName());
        holder.binding.tvPassword.setText(contactList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{

        ItemLayoutBinding binding;

        public ItemHolder(@NonNull ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
