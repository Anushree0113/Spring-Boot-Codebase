package SpringBootProject.JournalEntry;

import SpringBootProject.JournalEntry.entry.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private final Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/get/JournalEntry")
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/add/JournalEntry")
    public boolean createEntry(@RequestBody JournalEntry entry) {
        journalEntries.put(entry.getId(), entry);
        return true;

    }

    @GetMapping("/id/{myid}")
    public JournalEntry getEntryById(@PathVariable Long myid) {
        return journalEntries.get(myid);
    }

    @DeleteMapping("/deleteEntry/{myId}")
    public boolean deleteEntry(@PathVariable Long myId) {
        journalEntries.remove(myId);
        return true;
    }

    @PutMapping("/update/{myid}")
    public boolean updateEntry(@PathVariable Long myid, @RequestBody JournalEntry entry) {
        journalEntries.put(myid, entry);
        return true;
    }
}
