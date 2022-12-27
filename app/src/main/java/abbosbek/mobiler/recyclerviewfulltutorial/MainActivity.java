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

        loadContact();

        contactAdapter = new ContactAdapter(new ContactAdapter.OnClickListener() {
            @Override
            public void onDelete(Contact contact, int position) {
                contactList.remove(contact);
            }
        });

        contactAdapter.submitList(contactList);
        binding.recyclerContact.setAdapter(contactAdapter);

    }

    private void loadContact(){
        contactList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contactList.add(new Contact("abbosbek -> " +i,"132546 -> "+ i));
        }
    }
}