package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public ComboBox<KeyValuePair> comb_countries;
    public ComboBox<KeyValuePair> comb_cities;
    public ComboBox<KeyValuePair> comb_universities;
    public ComboBox<KeyValuePair> comb_schooles;
    public ComboBox<KeyValuePair> comb_fromAge;
    public ComboBox<KeyValuePair> comb_toAge;
    public ComboBox<KeyValuePair> comb_universYear;
    public ComboBox<KeyValuePair> comb_status;
    public TextField texF_searchCity;
    public TextField texF_searchUsers;
    public TextField texF_login;
    public TextField texF_time;
    public TextArea text_message;
    public PasswordField pasF_password;
    public Button btn_searchCity;
    public Button btn_searchUsers;
    public Button btn_auth;
    public Button btn_sendMessage;
    public Button btn_exit;
    public RadioButton rbtn_woman;
    public RadioButton rbtn_man;
    public RadioButton rbtn_all;
    public Label lab_count;
    public Label lab_user;
    public static CheckBox cheb_visiblePhoto;
    public int sex = 0;

    private VKapi vKapi= new VKapi();


    public  static JSONArray Users;
    public  static ArrayList<Image> fximages;


    public ListView lisV_Users;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comb_countries.setValue(new KeyValuePair(0, "Выбор страны"));
        comb_cities.setValue(new KeyValuePair(0, "Выбор города"));
        comb_universities.setValue(new KeyValuePair(0, "Выбор университета"));
        comb_schooles.setValue(new KeyValuePair(0, "Выбор школы"));
        comb_fromAge.setValue(new KeyValuePair(0, "От"));
        comb_toAge.setValue(new KeyValuePair(0, "До"));
        comb_universYear.setValue(new KeyValuePair(0, "год выпуска"));
        comb_status.setValue(new KeyValuePair(0, "Семейный статус"));
        lisV_Users.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new AttachmentListCell();
            }
        });

        lisV_Users.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        initAgeAndUnivYear();
        JSONArray ar = vKapi.getCountries(0);
        initCombobox(comb_countries, ar, "Выбор страны");
        ar = vKapi.getCountries(1);
        for (int i = 0; i < ar.length(); i++) {
            if(!comb_countries.getItems().contains(new KeyValuePair(ar.getJSONObject(i).getInt("id"),
                    ar.getJSONObject(i).getString("title")))){
                comb_countries.getItems().add(new KeyValuePair(ar.getJSONObject(i).getInt("id"),
                        ar.getJSONObject(i).getString("title")));
            }
        }
    }

    public void comboxCountryActionOnClick(){
        if(comb_countries.getValue().getKey() == 0){
            searchCityDisable(true);
        }else{
            searchCityDisable(false);
            JSONArray ar = vKapi.getCities(comb_countries.getValue().getKey(), texF_searchCity.getText().replace(" ","%20"),
                    texF_searchCity.getText().length() > 0 ? 1 : 0);
            initCombobox(comb_cities, ar, "Выбор города");
        }
    }

    public void initAgeAndUnivYear(){
        comb_fromAge.getItems().add(new KeyValuePair(0, "От"));
        comb_toAge.getItems().add(new KeyValuePair(0, "До"));
        comb_universYear.getItems().add(new KeyValuePair(0, "Год выпуска"));
        comb_status.getItems().add(new KeyValuePair(0, "Семейный статус"));
        for(int i = 14; i < 81; i++){
            comb_fromAge.getItems().add(new KeyValuePair(i, "от " + i));
            comb_toAge.getItems().add(new KeyValuePair(i, "до " + i));
            comb_universYear.getItems().add(new KeyValuePair((80 - i) + 1930, "" + ((80 - i) + 1930)));
        }
        comb_status.getItems().add(new KeyValuePair(1, "Не женат"));
        comb_status.getItems().add(new KeyValuePair(2, "Встречается"));
        comb_status.getItems().add(new KeyValuePair(3, "Помолвлен"));
        comb_status.getItems().add(new KeyValuePair(4, "Женат"));
        comb_status.getItems().add(new KeyValuePair(5, "Всё сложно"));
        comb_status.getItems().add(new KeyValuePair(6, "В активном поиске"));
        comb_status.getItems().add(new KeyValuePair(7, "Влюблён"));
    }

    public void radioSelectedOnClick(){
        if(rbtn_all.isSelected()){
            sex = 0;
        }else if(rbtn_woman.isSelected()){
            sex = 1;
        }else if(rbtn_man.isSelected()){
            sex = 2;
        }
    }

    public void initCombobox(ComboBox<KeyValuePair> cb, JSONArray ar, String text){
        cb.getItems().clear();
        cb.getItems().add(new KeyValuePair(0, text));
        cb.setValue(new KeyValuePair(0, text));
        for (int i = 0; i < ar.length(); i++) {
            cb.getItems().add(new KeyValuePair(ar.getJSONObject(i).getInt("id"),
                    ar.getJSONObject(i).getString("title")));
        }
    }

    public void searchCityDisable(boolean flag){
        comb_cities.setDisable(flag);
        texF_searchCity.setDisable(flag);
        btn_searchCity.setDisable(flag);
        searchUniverAndSchooleSityDisable(true);
    }

    public void searchUniverAndSchooleSityDisable(boolean flag){
        comb_universities.setDisable(flag);
        comb_schooles.setDisable(flag);
        comb_universYear.setDisable(flag);
        comb_universities.setValue(new KeyValuePair(0, "Выбор университета"));
        comb_schooles.setValue(new KeyValuePair(0, "Выбор школы"));
        comb_universYear.setValue(new KeyValuePair(0, "Год выпуска"));
    }

    public void btnSearchCityOnClick(){
        comboxCountryActionOnClick();
    }

    public void comboxCityActionOnClick(){
        if(comb_cities.getValue() == null || comb_countries.getValue() == null) {
            searchUniverAndSchooleSityDisable(true);
            return;
        }
        if(comb_countries.getValue().getKey() == 0 || comb_cities.getValue().getKey() == 0){
            searchUniverAndSchooleSityDisable(true);
        }else{
            searchUniverAndSchooleSityDisable(false);
            JSONArray ar = vKapi.getUniversities(comb_countries.getValue().getKey(), comb_cities.getValue().getKey());
            initCombobox(comb_universities, ar, "Выбор университета");
            ar = vKapi.getSchools(comb_cities.getValue().getKey());
            initCombobox(comb_schooles, ar, "Выбор школы");
        }
    }

    public void searchOnClick(){
        Users = vKapi.search(texF_searchUsers.getText().replace(" ", "%20"), comb_countries.getValue().getKey(),
                comb_cities.getValue().getKey(),
                comb_universities.getValue().getKey(),
                comb_universYear.getValue().getKey(),
                sex,
                comb_status.getValue().getKey(),
                comb_fromAge.getValue().getKey(),
                comb_toAge.getValue().getKey(),
                comb_schooles.getValue().getKey());
        lab_count.setText("Найдено: " + Users.length());
        fximages = new ArrayList<>();
        lisV_Users.getItems().clear();
        for(int i = 0; i < Users.length(); i++){
            if(i < 30 && cheb_visiblePhoto.isSelected()) {
                fximages.add(new Image(Users.getJSONObject(i).getString("photo_50")));
            }
            lisV_Users.getItems().add(i+"");
        }
    }

    class KeyValuePair {
        private final int key;
        private final String value;
        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.key == ((KeyValuePair) obj).key;
        }
    }

    private static class AttachmentListCell extends ListCell<String> {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                try {
                    if (cheb_visiblePhoto.isSelected()) {
                        if (Integer.parseInt(item) > fximages.size() - 1) {
                            int size = fximages.size();
                            for (int i = size; i < size + 30 && i < Users.length(); i++) {
                                fximages.add(new Image(Users.getJSONObject(i).getString("photo_50")));
                            }
                        }
                        ImageView imageView = new ImageView(fximages.get(Integer.parseInt(item)));
                        setGraphic(imageView);
                    }
                    if (!cheb_visiblePhoto.isSelected()) {
                        this.setGraphic(null);
                    }
                    String string = Users.getJSONObject(Integer.parseInt(item)).getString("first_name") + " " +
                            Users.getJSONObject(Integer.parseInt(item)).getString("last_name") + "\nid: " +
                            Users.getJSONObject(Integer.parseInt(item)).getInt("id");
                    setText(string);
                }
                catch (Exception ex){};
            }
        }
    }

    public void sendMessages(){
        Thread myThready = new Thread(new Runnable() {
            public void run()
            {
                for (int i = 0; i < Users.length(); i++){
                    try{
                        Thread.sleep(1000* Integer.parseInt(texF_time.getText()));
                        vKapi.sendMessages(Users.getJSONObject(i).getInt("id"), text_message.getText());

                    }
                    catch (Exception ex){}
                }
            }
        });
        myThready.start();
    }

    public void buttonAuthOnClick(){
        try {
            vKapi.authorize(texF_login.getText(), pasF_password.getText());
        }
        catch (Exception ex){
            lab_user.setText("Ошибка");
            return;
        }
        btn_searchUsers.setDisable(false);
        btn_sendMessage.setDisable(false);
        btn_exit.setDisable(false);
        btn_auth.setDisable(true);
        texF_login.setDisable(true);
        pasF_password.setDisable(true);
        JSONArray ar = vKapi.getUser();
        lab_user.setText(ar.getJSONObject(0).getString("first_name") + " "+
                ar.getJSONObject(0).getString("last_name"));
    }

    public void buttonExitOnClick(){
        btn_searchUsers.setDisable(true);
        btn_sendMessage.setDisable(true);
        btn_exit.setDisable(true);
        btn_auth.setDisable(false);
        texF_login.setDisable(false);
        pasF_password.setDisable(false);
        lab_user.setText("");
    }


}
