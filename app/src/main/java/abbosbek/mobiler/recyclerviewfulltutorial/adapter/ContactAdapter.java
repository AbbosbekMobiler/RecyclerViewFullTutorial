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
    private OnClickListener listener;

    public ContactAdapter(List<Contact> contactList, OnClickListener listener) {
        this.contactList = contactList;
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

        Contact contact = contactList.get(position);

        holder.binding.tvName.setText(contact.getName());
        holder.binding.tvPassword.setText(contact.getPassword());
        
        holder.itemView.setOnClickListener(view -> listener.onClick(contact,position));

        holder.binding.btnDelete.setOnClickListener(view -> listener.onDelete(contact,position));
        holder.binding.btnEdit.setOnClickListener(view -> listener.onEdit(contact,position));

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

    public interface OnClickListener{
        void onClick(Contact contact,int position);
        void onDelete(Contact contact,int position);
        void onEdit(Contact contact,int position);
    }
}
