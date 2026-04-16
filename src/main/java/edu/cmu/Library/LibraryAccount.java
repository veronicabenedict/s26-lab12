package edu.cmu.Library;

public class LibraryAccount {
    private LibraryService libraryService;
 
    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. Since multiple households may
     * share a single account, the user ID is of the form "libraryID:userName".
     * e.g., "12345:John Doe"
     *
     * @param userId the ID of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     */
    public Book[] getBooks(String userId) {
        String[] parts = userId.split(":");
        // needed to switch id and name order
        // because API doc says userID form is id:name
        String id = parts[0]; 
        String name = parts[1];
        return libraryService.getBooks(name, id);        
    }
}
