# VoteGR -  *Ψήφισε με ασφάλεια*

> Δημοκρατία είναι η κυβέρνηση του λαού, από το λαό, για το λαό.
>
>  &mdash; <cite>Αβραάμ Λίνκολν</cite>

### The English version of the README is available [HERE](https://github.com/geras-papax/VoteGR/blob/main/README.md)

<p align="center">
  <img src="https://github.com/geras-papax/VoteGR/blob/main/images/logo.png" width="300" height="300" alt="Logo">
</p>

## :dart: Εισαγωγή :dart:

Το παρόν repository αποτελεί το project μας για το μάθημα της Τεχνολογίας Λογισμικού του [Τμήματος Μηχανικών Η/Υ & Πληροφορικής](https://www.ceid.upatras.gr/el).
 

## :question: Περιγραφή :question:

Η εφαρμογή απευθύνεται σε τρεις κατηγορίες χρηστών: Πολίτης, Κόμμα και Διαχειριστής.<br>
Ο πολίτης μπορεί να ψηφίζει και να βλέπει τα αποτελέσματα από δημοψηφίσματα που διεξάγονται από το κράτος. Στην πλατφόρμα είναι επίσης διαθέσιμες οι επίσημες απόψεις των κομμάτων της Βουλής. Οι εν λόγω απόψεις καταγράφονται είτε με απευθείας ανάρτηση του κόμματος στην εφαρμογή, είτε αντλούνται αυτόματα από τον λογαριασμό των κομμάτων στο Twitter. Από την πλευρά του το κράτος μπορεί να δημιουργεί δημοψηφίσματα και να παραχωρεί δικαιώματα ανάρτησης θέσεων μόνο στα κόμματα που ανήκουν στη Βουλή ύστερα από τις εθνικές εκλογές. Η είσοδος του κάθε πολίτη στην πλατφόρμα γίνεται μέσω του συστήματος taxisnet ώστε να διασφαλίζεται η ακεραιότητα της διαδικασίας ενώ η είσοδος του γραφείου τύπου των κομμάτων γίνεται μέσω ταυτοποίησης με το Twitter API.


## :hammer: Αρχιτεκτονική :hammer:

<p align="center">
  <img src="https://github.com/geras-papax/VoteGR/blob/main/images/system_architecture.png" alt="System Architecture">
</p>

Το παραπάνω διάγραμμα αντικατοπτρίζει την αρχιτεκτονική του project μας. Πρόκειται για:
- Εφαρμογή Android: έγινε υλοποίηση μέσω Android Studio και εξομοίωση σε Android Virtual Device (AVD). Για τα HTTP Requests χρησιμοποιήθηκε η προτεινόμενη από τη Google βιβλιοθήκη, Volley.
- PHP API: έγινε υλοποίηση μέσω του εξυπηρέτη ιστού Apache. Σκοπός του API που δημιουργήθηκε είναι η αποστολή ερωτημάτων προς της βάση δεδομένων και η επιστροφή των ζητούμενων σε μορφή JavaScript Object Notation (JSON), το πιο γνωστό μορφότυπο δεδομένων που χρησιμοποιείται για την ασύγχρονη επικοινωνία διακομιστή-περιήγηση.
- Βάση Δεδομένων MySQL: έγινε υλοποίηση μέσω του phpMyAdmin, ένα εργαλείο ελεύθερου λογισμικού γραμμένο σε PHP, που επιτρέπει τη διαχείριση μιας βάσης δεδομένων MySQL μέσω του Διαδικτύου. Η σχεδίαση είναι τέτοια ώστε να επιτρέπει τα ζητούμενα ερωτήματα να εκτελούνται εύκολα και γρήγορα.


## :family: Ομάδα :family:
- [Καραβοκύρης Μιχαήλ](https://github.com/karavokyrismichail)
- [Κουνέλης Αγησίλαος](https://github.com/kounelisagis)
- [Κουτσοχέρας Ιωάννης](https://github.com/koutsocheras99)
- [Παπαχρονόπουλος Γεράσιμος](https://github.com/geras-papax)


## :zap: GitHub Workflow :zap:

Σε κάθε περίπτωση θέλαμε οι αλλαγές να μην επηρεάζουν άμεσα το main branch. Για το λόγο αυτό ο δημιουργός του repository (Παπαχρονόπουλος) δημιουργούσε ξεχωριστό branch σε κάθε παραδοτέο και εφάρμοζε τις αλλαγές του εκεί. Τα υπόλοιπα μέλη της ομάδας (Καραβοκύρης, Κουτσοχέρας, Κουνέλης) έκαναν fork το repository και δούλευαν στο fork τους, φροντίζοντας να είναι up to date με το αρχικό repo (δηλαδή να κάνουν τακτικά fetch and merge από το upstream). Όταν κάποιο μέλος τελείωνε με το κομμάτι που είχε κάθε φορά αναλάβει, άνοιγε pull request προς το main branch ώστε κάποιο άλλο μέλος της ομάδας να το εξετάσει και να το κάνει merge εφόσον οι αλλαγές ήταν σωστές. Φροντίσαμε έτσι ώστε τα μηνύματα που συνοδεύουν κάθε commit να είναι περιγραφικά για τις αλλαγές που έγιναν. Έτσι μπορεί κάποιος βλέποντας τα commits να διαπιστώσει πότε και πως έγιναν οι αλλαγές στον κώδικα που ψάχνει.Με λίγα λόγια ο τρόπος που δουλέψαμε είναι ένας συνδυασμός συνδυασμός Forking Workflow και Branch Workflow.

Αξίζει να σημειωθεί πως σε μία προσπάθεια διευκόλυνσης των μελών της ομάδας μας, έγινε χρήση των δυνατοτήτων του GitHub για ορισμό Reviewers, Assignees και Labels στα pull requests. Ως μια εξίσου καλή πρακτική, στο project χρησιμοποιήθηκαν issues. Το κάθε issue έκλεισε (έγινε closed) με το κατάλληλο pull request. Όπως και στα pull requests έτσι και στα issues χρησιμοποιήθηκαν οι επιλογές για Assignees και Labels.


Τα links για τα branches του project:
- [Main Branch](https://github.com/geras-papax/VoteGR/tree/main)
- [Branch 1](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_2_11/04%2F21)
- [Branch 2](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_3_25/04%2F21)
- [Branch 3](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_4_23/05%2F21)
- [Branch 4](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_5_06/06%2F21)
- [Branch 5](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_6_11/06%2F21)

Τα links για τα forks του project:
- [Καραβοκύρης Μιχαήλ](https://github.com/karavokyrismichail/VoteGR)
- [Κουνέλης Αγησίλαος](https://github.com/kounelisagis/VoteGR)
- [Κουτσοχέρας Ιωάννης](https://github.com/koutsocheras99/VoteGR)




## :wrench: Εργαλεία :wrench:

- [Android Studio](https://developer.android.com/studio) - [Volley Library](https://developer.android.com/training/volley)
- [XAMPP (Apache + MySQL)](https://www.apachefriends.org/index.html)
- [Visual Studio Code](https://code.visualstudio.com/) - [Live Share Extension](https://marketplace.visualstudio.com/items?itemName=MS-vsliveshare.vsliveshare)


## :arrow_forward: Εκτέλεση :arrow_forward:
- Μέσω του Android Studio Build και Run της Android εφαρμογής
- Μέσω του XAMPP build της MySQL βάσης και διερμηνεία του κώδικα PHP στο backend

> Σημείωση: στον κώδικα του Android Studio για την αποστολή των HTTP requests έχει χρησιμοποιηθεί η διεύθυνση `http://192.168.2.4`. Αυτή ενδέχεται να χρειάζεται αλλαγή σε κάποια άλλη IP address προσβάσιμη από το εκάστοτε home network.

