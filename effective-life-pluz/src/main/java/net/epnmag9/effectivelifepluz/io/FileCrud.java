package net.epnmag9.effectivelifepluz.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public abstract class FileCrud<O> implements Crud<String,O>{
    String basePath;
    
    public FileCrud(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public void create(String key, O object) {
        try (FileOutputStream fos = new FileOutputStream(Path.of(basePath,key).toFile())) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @SuppressWarnings("unchecked")
    public O read(String key) {
        try (FileInputStream fis = new FileInputStream(Path.of(basePath,key).toFile())) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (O) ois.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(String key, O object) {
        try (FileOutputStream fos = new FileOutputStream(Path.of(basePath,key).toFile())) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
