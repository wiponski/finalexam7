package com.example.exam7.service;

import com.example.exam7.dao.ClientDao;
import com.example.exam7.dao.DishDao;
import com.example.exam7.dao.InstitutionDao;
import com.example.exam7.dao.OrderDao;
import com.example.exam7.dto.DishDto;
import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Institution;
import com.example.exam7.entity.Order;
import com.example.exam7.unit.GenerateData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final DataBaseConnectivity dbService;
    private final ClientDao clientDao;
    private final InstitutionDao institutionDao;
    private final DishDao dishDao;
    private final OrderDao orderDao;

    private int executeUpdate(String query) throws SQLException {
        Statement statement = dbService.getConn().createStatement();
        return statement.executeUpdate(query);
    }

    private void createClientTable() throws SQLException {
        String dropTableQuery = " DROP TABLE IF EXISTS orders;"
                + " DROP TABLE IF EXISTS dishes;"
                + " DROP TABLE IF EXISTS institutions;"
                + "DROP TABLE IF EXISTS clients;";
        String createTableQuery = "CREATE TABLE clients ("
                + "id bigserial PRIMARY KEY,"
                + "name TEXT, "
                + "email TEXT UNIQUE, "
                + "password TEXT "
                + ");";
//        String clientEntryQuery = "INSERT INTO clients (clientname, email, password) "
//                + "VALUES ( 'Brain', 'brain@test', 'pass')";
        String clientEntryQuery = "";
        executeUpdate(dropTableQuery);
        executeUpdate(createTableQuery);
        executeUpdate(clientEntryQuery);
    }

    private void createInstitutionTable() throws SQLException {

        String createTableQuery = "CREATE TABLE institutions ("
                + "id bigserial PRIMARY KEY,"
                + "name TEXT, "
                + "description TEXT "
                + ");";
        String dishEntryQuery = "";
        executeUpdate(createTableQuery);
        executeUpdate(dishEntryQuery);
    }

    private void createDishTable() throws SQLException {

        String createTableQuery = "CREATE TABLE dishes ("
                + "id bigserial PRIMARY KEY,"
                + "name TEXT, "
                + "type TEXT,"
                + "price integer not null default 0,"
                + "institution_id integer not null, "
                + "CONSTRAINT institution_FK FOREIGN KEY(institution_id) REFERENCES institutions (id) ON DELETE CASCADE"
                + ");";
        String dishEntryQuery = "";

        executeUpdate(createTableQuery);
        executeUpdate(dishEntryQuery);

    }


    private void createOrderTable() throws SQLException {

        String createTableQuery = "CREATE TABLE orders ("
                + "id bigserial PRIMARY KEY,"
                + "client_id integer not null, "
                + "dish_id integer not null, "
                + "order_date TIMESTAMP NOT NULL,"
                + "CONSTRAINT client_FK FOREIGN KEY(client_id) REFERENCES clients (id) ON DELETE CASCADE,"
                + "CONSTRAINT dish_FK FOREIGN KEY(dish_id) REFERENCES dishes (id) ON DELETE CASCADE"
                + ");";
        String dishEntryQuery = "";
        executeUpdate(createTableQuery);
        executeUpdate(dishEntryQuery);
    }


    public String shouldCreateTable() {
        try {
            createClientTable();
            createInstitutionTable();
            createDishTable();
            createOrderTable();
            dbService.getConn().createStatement().execute("select * from clients;");
            return "All it's OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Client> getClients() {
        return clientDao.getAllClients();
    }

    public void insertClient() {
        for (int i = 0; i < 3; i++) {
            clientDao.addClient(Client.builder()
                            .name(GenerateData.randomPersonName())
                            .email(GenerateData.randomEmail())
                            .password("123")
                    .build());
        }
    }

    public void insertClient(Client client) {
        clientDao.addClient(client);
    }
    public void insertInstitutions() {
        for (int i = 0; i < 3; i++) {
            institutionDao.addInstitution(Institution.builder()
                    .name(GenerateData.randomPlace().name)
                    .description(GenerateData.randomPlace().description)
                    .build());
        }
    }
    public void insertInstitutions(Institution institution) {
        institutionDao.addInstitution(institution);
    }


    public void insertDish() {
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            dishDao.addDish(DishDto.builder()
                    .name(GenerateData.randomDish().name)
                    .type(GenerateData.randomDish().type)
                    .price(rnd.nextInt(100))
                     .institution_id(1L)
                    .build());
        }
    }
    public void insertDish(DishDto dish) {
        dishDao.addDish(dish);
    }


    public List<Institution> getInstitutions() {
        return institutionDao.getAllInstitutions();
    }

    public void insertOrder(OrderDto order) {
        orderDao.addOrder(order);
    }


    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

}
