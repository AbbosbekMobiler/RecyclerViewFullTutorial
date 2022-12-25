package abbosbek.mobiler.recyclerviewfulltutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import abbosbek.mobiler.recyclerviewfulltutorial.adapter.ContactAdapter;
import abbosbek.mobiler.recyclerviewfulltutorial.databinding.ActivityMainBinding;
import abbosbek.mobiler.recyclerviewfulltutorial.model.Contact;

public class MainActivity extends AppCompatActivity {

    private ContactAdapter contactAdapter;

    private List<Contact> contactList;

    private ActivityMainBinding binding;

    private int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contactList = new ArrayList<>();

        contactAdapter = new ContactAdapter(contactList, new ContactAdapter.OnClickListener() {
            @Override
            public void onClick(Contact contact, int position) {
                Toast.makeText(MainActivity.this, contact.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDelete(Contact contact, int position) {

                contactList.remove(position);
                contactAdapter.notifyItemRemoved(position);
                contactAdapter.notifyItemRangeChanged(position,contactList.size());

            }

            @Override
            public void onEdit(Contact contact, int position) {

                binding.etName.setText(contact.getName());
                binding.etPassword.setText(contact.getPassword());
                index = position;

            }
        });

        binding.recyclerContact.setAdapter(contactAdapter);

        binding.btnSave.setOnClickListener(view -> {
            String name = binding.etName.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (index == -1){
                Contact contact = new Contact(name,password);
                contactList.add(contact);
                contactAdapter.notifyItemInserted(contactList.size());
            }else {
                contactList.get(index).setName(name);
                contactList.get(index).setPassword(password);
                contactAdapter.notifyItemChanged(index);
            }
            binding.etName.setText("");
            binding.etPassword.setText("");
        });

    }
}