package com.example.votegr.ui.statement;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StatementViewModel extends ViewModel {

    private MutableLiveData<String> vote_question;

    public StatementViewModel() {
        vote_question = new MutableLiveData<>();
        vote_question.setValue("Πρέπει να γίνει αποδεκτό το σχέδιο συμφωνίας, το οποίο κατέθεσαν η Ευρωπαϊκή Επιτροπή, η Ευρωπαϊκή Κεντρική Τράπεζα" +
                "και το Διεθνές Νομισματικό Ταμείο στο Eurogroup της 25.06.2015 και αποτελείται από δύο μέρη, τα οποία συγκροτούν την ενιαία πρότασή τους;" +
                "Το πρώτο έγγραφο τιτλοφορείται «Reforms for the completion of the Current Program and Beyond» («Μεταρρυθμίσεις για την ολοκλήρωση του τρέχοντος προγράμματος" +
                "και πέραν αυτού») και το δεύτερο «Preliminary Debt sustainability analysis» («Προκαταρκτική ανάλυση βιωσιμότητας χρέους");
    }

    public LiveData<String> getVoteQuestion() {
        return vote_question;
    }
}