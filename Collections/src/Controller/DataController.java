/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static java.lang.Math.E;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

/**
 *
 * @author Jeroen Hendriks
 */
public class DataController implements Initializable {

    @FXML
    TreeView<String> tvOrganistatie;
    @FXML
    TableView tbbvMedewerkers;
    @FXML
    Button btnAdd;
    @FXML
    Button btnDelete;

    private ArrayList<Afdeling> afdelingen;
    private ArrayList<Medewerker> medewerkers;
    private ObservableList<Afdeling> obsAfdelingen;
    private ObservableList<Medewerker> obsMedewerkers;
    private TreeItem<String> selectedItem;
    private TreeItem<String> rootItem;

    public void vulTestdata() {
        //Afdelingen
        Afdeling a = new Afdeling("FHICT", 1, "");
            Afdeling b = new Afdeling("Directie", 2, "FHICT");
            Afdeling c = new Afdeling("ISSD", 3, "FHICT");
            Afdeling d = new Afdeling("Onderwijs", 4, "FHICT");
                Afdeling e = new Afdeling("Profiel", 5, "Onderwijs");
                    Afdeling f = new Afdeling("Team S", 6, "Profiel");
                    Afdeling g = new Afdeling("Team T", 7, "Profiel");
                    Afdeling h = new Afdeling("Team B", 8, "Profiel");
                    Afdeling i = new Afdeling("Team M", 9, "Profiel");
                Afdeling j = new Afdeling("Innovatie", 10, "Onderwijs");
                    Afdeling k = new Afdeling("ICS", 11, "Innovatie");
                    Afdeling l = new Afdeling("IMS", 12, "Innovatie");
                    Afdeling m = new Afdeling("SM", 13, "Innovatie");
                    Afdeling n = new Afdeling("EDU", 14, "Innovatie");
                    Afdeling o = new Afdeling("GD", 15, "Innovatie");
                    Afdeling p = new Afdeling("DP", 16, "Innovatie");
                    Afdeling q = new Afdeling("LS", 17, "Innovatie");

        //Medewerker
        Medewerker ma = new Medewerker(1, "Lisa van Kessel", "Directie");
        Medewerker mb = new Medewerker(2, "Jeroen Hendriks", "ISSD");
        Medewerker mc = new Medewerker(3, "Jurgen van den Berg", "ISSD");
        Medewerker md = new Medewerker(4, "Thom Bijsterbosch", "Team S");
        Medewerker me = new Medewerker(5, "Kevin Grond", "Team S");
        Medewerker mf = new Medewerker(6, "Tijn Renders", "Team T");
        Medewerker mg = new Medewerker(7, "Eric van Aert", "Team B");
        Medewerker mh = new Medewerker(8, "Lars Jaeqx", "ICS");
        Medewerker mi = new Medewerker(9, "Wouter Habets", "IMS");
        Medewerker mj = new Medewerker(10, "Diane Melaan", "EDU");
        Medewerker mk = new Medewerker(11, "Konghon Choo", "GD");

        afdelingen.addAll(Arrays.asList(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q));
        medewerkers.addAll(Arrays.asList(ma, mb, mc, md, me, mf, mg, mh, mi, mj, mk));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afdelingen = new ArrayList();
        medewerkers = new ArrayList();
        vulTestdata();
        obsAfdelingen = FXCollections.observableList(afdelingen);
        obsMedewerkers = FXCollections.observableList(medewerkers);

        //TableView
        TableColumn clmNaam = new TableColumn("Naam");
        TableColumn clmAfdeling = new TableColumn("Afdeling");
        tbbvMedewerkers.getColumns().addAll(clmNaam, clmAfdeling);
        tbbvMedewerkers.setEditable(true);

        clmNaam.setCellFactory(TextFieldTableCell.forTableColumn());
        clmNaam.setOnEditCommit(new EventHandler<CellEditEvent<Medewerker, String>>() {
            @Override
            public void handle(CellEditEvent<Medewerker, String> event) {
                ((Medewerker) event.getTableView().getItems().get(event.getTablePosition().getRow())).setNaam(event.getNewValue());
                refreshTable();
            }
        });

        clmAfdeling.setCellFactory(TextFieldTableCell.forTableColumn());
        clmAfdeling.setOnEditCommit(new EventHandler<CellEditEvent<Medewerker, String>>() {
            @Override
            public void handle(CellEditEvent<Medewerker, String> event) {
                ((Medewerker) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAfdeling(event.getNewValue());
                refreshTable();
            }
        });

        clmNaam.setCellValueFactory(new PropertyValueFactory<Medewerker, String>("naam"));
        clmAfdeling.setCellValueFactory(new PropertyValueFactory<Medewerker, String>("afdeling"));

        //TreeView
        tvOrganistatie.setEditable(true);
        tvOrganistatie.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });

        tvOrganistatie.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                selectedItem = newValue;
                refreshTable();
            }
        });

        refreshTree();
    }

    // Vult de treeitem met children, recursief wordt gekeken naar children en toegevoegd aan de parent.
    public TreeItem<String> FillTree(TreeItem<String> item, Iterator childAfdelingen) {
        Iterator it = childAfdelingen;
        TreeItem<String> leafItem = null;

        while (it.hasNext()) {
            Afdeling a = (Afdeling) it.next();
            leafItem = new TreeItem<String>(a.getNaam(), null);
            FillTree(leafItem, getChilds(a.getNaam()).iterator());
            item.getChildren().add(leafItem);
        }
        return item;
    }

    //Haalt alle childs op van de gekozen afdeling
    public ArrayList<Afdeling> getChilds(String naam) {
        ArrayList<Afdeling> afd = new ArrayList<>();

        for (Afdeling a : obsAfdelingen) {
            if (a.getParentID().equals(naam)) {
                afd.add(a);
            }
        }
        return afd;
    }

    //Vult de medewerkerstable op basis van het geselecteerde treeview item. Als het FHICT is dan wordt alles getoond
    private void fillMedewerkers(String value) {
        ArrayList<Medewerker> med = new ArrayList<>();

        if (value.equals("FHICT")) {
            tbbvMedewerkers.setItems(obsMedewerkers);
            return;
        }

        for (Medewerker m : obsMedewerkers) {
            if (m.getAfdeling().equals(value)) {
                med.add(m);
            }
        }
        tbbvMedewerkers.setItems(FXCollections.observableList(med));
    }

    //Event voor de toevoegen knop
    public void add(Event evt) {
        Medewerker a = new Medewerker(medewerkers.size() + 1, "...", selectedItem.getValue());
        medewerkers.add(a);

        refreshTable();
    }

    //Event voor de verwijderen knop
    public void delete(Event evt) {
        int i = tbbvMedewerkers.getSelectionModel().getSelectedIndex();
        Medewerker m = (Medewerker) tbbvMedewerkers.getSelectionModel().getSelectedItem();
        medewerkers.remove(m);

        refreshTable();
    }

    
    //vult de medewerkers opnieuw
    public void refreshTable() {
        fillMedewerkers(selectedItem.getValue());
    }

    //Refresht de treeview met nieuwe waardes
    public void refreshTree() {
        rootItem = new TreeItem<String>(obsAfdelingen.get(0).getNaam());

        FillTree(rootItem, getChilds(obsAfdelingen.get(0).getNaam()).iterator());
        rootItem.setExpanded(true);

        tvOrganistatie.setRoot(rootItem);
    }

    //Verandert de waardes van een afdeling > naam en van alle childs
    private void veranderAfdeling(String oldName, String newName) {
        for (Afdeling a : afdelingen) {
            if (a.getNaam().equals(oldName)) {
                a.setNaam(newName);
            }
            if (a.getParentID().equals(oldName)) {
                a.setParentAfdeling(newName);
            }
        }
    }

    //Custom class voor het toevoegen van een nieuwe afdeling
    private final class TextFieldTreeCellImpl extends TreeCell<String> {

        private TextField textField;
        private ContextMenu addMenu = new ContextMenu();

        public TextFieldTreeCellImpl() {
            MenuItem addMenuItem = new MenuItem("Voeg afdeling toe");
            addMenu.getItems().add(addMenuItem);
            addMenuItem.setOnAction(new EventHandler() {
                public void handle(Event t) {
                    Afdeling a = new Afdeling("Nieuwe afdeling", afdelingen.size() + 1, getTreeItem().getValue());
                    TreeItem newAfdeling = new TreeItem<String>("Nieuwe afdeling");
                    getTreeItem().getChildren().add(newAfdeling);
                    afdelingen.add(a);
                }
            });
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            super.
                    setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());

                    setContextMenu(addMenu);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        veranderAfdeling(getString(), textField.getText());
                        commitEdit(textField.getText());
                        //refreshTree();
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}
