# CSVtoSQL
Read a CSV file into an SQL database using a java program

This project had the intial aim to transfer a csv file to a mySQL database using Java.

This has been accomplishe dby the uploaded file through these steps

- Read a CSV file into the program thats held within the package
- This is then scanned for duplicate Employee ID's
- If any are found they're removed and a clean list is sent through
- This list is then broken up into multiple sublists that can be spread across many threads
- These threads are then activated through a seperate class
- These threads are each given the task of reading these values into the database throuhg SQL prepreppared statements


This process has not yet be refinned to speed up the transfer of files, and still takes a long time to send. This is in part due to the threading process not working as intended, as only a single thread avoids a duplicate entry error. This will be fixed in future pushes.

The use of hash maps has been implented to speed up duplicate finding, reducing the time for a list of 10000 to only 17ms.
