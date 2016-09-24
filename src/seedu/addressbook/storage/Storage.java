package seedu.addressbook.storage;

import java.nio.file.Path;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Storage {
    
    //The file path being used if file name is not being provided by users
    public static final String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";

    //file path that does not fufill the storage filepath constraints
    public static class InvalidStorageFilePathException extends IllegalValueException {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }

    //error occurred while converting && reading/writing data between app and storage file
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }

    //If path is acceptable as storage file, return true 
    //in this case, it is only acceptable if it ends with txt
    protected static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }
    
    public abstract AddressBook load() throws StorageOperationException;
    
    public abstract void save(AddressBook book) throws StorageOperationException;
    
    public abstract String getPath();
}