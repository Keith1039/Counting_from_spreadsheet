How to use the program:
    First save the spreadsheet as a txt file by hitting file, then going to save as, and then clicking  save as type and set it to text(tab delimited).
    Next you are going to save that new text file in a folder with the program.

    Furthermore, this program is made to count things in the spreadsheet. Essentially, it will only really care about the "make" and "model" of the item.
    If you feel like it, you can manipulate this and have it count other things as well. So long as the format is the same as the CFS_and_EWASTE spreadsheet it 
    should work. Also, you would have to name the file CFS_and_EWASTE-Template.txt if you wish to do this since I'm assuming that this program will be used for that.
    That's the default name for when you try to save the ewaste spreadsheet.

    Finally, There are probably a million more efficient methods to do this but it involves some complex things that I'm not even 100% sure of. I'm sidestepping 
    them by using a .txt file instead of reading directly from the spreadsheet data. It's a step down in efficiency but it will Hopefully make this program easier
    to work with on your end.

    Be sure to update keys.txt and Companies.txt occassionally. I've made a way for the program to tell you if something is wrong (even tells you the line number).


    To summarize:
    1: save the spreadsheet as a text file
    2: put the text file in the same folder as the program files(java files) and the keys.txt and companies.txt file
    3: Make sure the names of the files are correct(CFS_and_EWASTE-Template.txt, keys.txt and Companies.txt)
    4: run the program using the terminal
    5: Watch as the program tallies everything for you :)

    WARNING: 
    keys.txt and Companies.txt HAVE to be updated in order for the program to work.
    
Instructions for modifying Companies.txt file:
    Simply add the new company on the line after the latest one. Each line should have 1 company name on it.

Instructions for modifying the keys.txt file:
    The general format for the keys is Model numbers,..,#, Nickname(Basically an easily recognisable name)
    The # is the indicator for the program to know where the model numbers end so make sure to put it.

    I've separated them by the companies that have made them and have left a space between them. ie crestron model numbers are together etc
    This is purely for organization, whether the list of keys is 
    organized or not does not affect the program in the slightest. 

    Even with all of this I can't exactly guarantee that something won't go wrong and the program crashes. The best I can do is to limit the ways it can crash.
    I'm no expert programmer yet so I'm bound to make some oversights. In that case, I'd recommend you either contact me or some programmers in TC if there are
    any. If there are programmers in TC ....Hopefully they won't laugh at my code too much :).

    Good luck guys,

-Keith Compere

