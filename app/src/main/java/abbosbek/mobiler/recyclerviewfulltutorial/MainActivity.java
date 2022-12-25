package abbosbek.mobiler.recyclerviewfulltutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import abbosbek.mobiler.recyclerviewfulltutorial.adapter.ContactAdapter;
import abbosbek.mobiler.recyclerviewfulltutorial.databinding.ActivityMainBinding;
import abbosbek.mobiler.recyclerviewfulltutorial.model.Contact;

public class MainActivity extends AppCompatActivity {

    private ContactAdapter contactAdapter;

    private List<Contact> contactList;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadContactList();

        contactAdapter = new ContactAdapter(contactList);
        binding.recyclerContact.setAdapter(contactAdapter);
    }

    private void loadContactList() {
        contactList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contactList.add(new Contact("AbbosbekMobiler -> "+i,"12345678 -> "+i));
        }

    }
}