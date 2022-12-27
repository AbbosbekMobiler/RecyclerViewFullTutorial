package abbosbek.mobiler.recyclerviewfulltutorial.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import abbosbek.mobiler.recyclerviewfulltutorial.databinding.ItemLayoutBinding;
import abbosbek.mobiler.recyclerviewfulltutorial.model.Contact;
import abbosbek.mobiler.recyclerviewfulltutorial.utils.ItemTouchHelperAdapter;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ItemHolder> implements ItemTouchHelperAdapter {

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

    @Override
    public void itemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition){
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(contactList,i,i+1);
            }
        }else {
            for (int i = toPosition - 1; i >= fromPosition; i--) {
                Collections.swap(contactList,i,i-1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

        contactList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,contactList.size());

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
