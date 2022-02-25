package api;

import model.Status;
import model.Ticket;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Создание и проверка тикета */
public class CreateTicketTest extends BaseTest {


    @Test
    public void createTicketTest() {
        // todo: создать тикет и проверить, что он находится в системе
        Ticket ticket = BaseTest.buildNewTicket(Status.OPEN,2);
        createTicket(ticket);
        getTicket(idd);
    }


    protected void getTicket(int id) {
        // todo: отправить HTTP запрос на получение тикета по его id
    given().auth().basic("admin", "adminat")
                .pathParam("id", id)
                .when()
                .get("/api/tickets//{id}")
                .then()
                .statusCode(200);
    }
}
