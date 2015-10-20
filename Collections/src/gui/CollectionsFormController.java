/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.Afdeling;
import Controller.DataController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jeroen
 */
public class CollectionsFormController extends Application {
    
    DataController dc = new DataController(); 
    

    @FXML TreeView tvOrganistatie;
    @FXML TableView tbbvMedewerkers;
   
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CollectionsForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        TreeItem<String> rootItem = new TreeItem<String>("FHICT");;
        for(Afdeling a : dc.getAfdelingen())
        {
            if(a.getParentID()== 1)
            {
                 TreeItem<String> item = new TreeItem<String>(a.getNaam(), null);
                 rootItem.getChildren().add(item);
            }
        }
        rootItem.setExpanded(true);
        
        //TreeView<String> treeView = new TreeView<String>(rootItem);
        
        tvOrganistatie.setRoot(rootItem);
        
        
    }
      
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}