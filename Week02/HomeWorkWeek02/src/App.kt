import helper.CafeController
import model.animals.Cat
import model.caffe.Product
import model.caffe.Sponsorship
import model.people.Employee
import model.people.Patron
import model.shelter.Shelter

fun main() {
    val cafeController = CafeController()

    val shelterOne = Shelter("1", "South Jakarta", "+6282261980112")
    val shelterTwo = Shelter("2", "West Jakarta", "+6282260701213")

    val amzesmoro = Employee("200","amzesmoro", "sianturi", "amzesmoro@gmail.com",
        "+6281201234567", 15.00, "100-100-100", "01-01-2020")
    val ruli = Employee("201","ruli", "kalit", "rulikalit@gmail.com",
        "+6281212560123", 15.00, "101-101-101", "01-01-2020")
    val evrin = Employee("202","evrin", "tobing", "evrintobing@gmail.com",
        "+6281210105656", 15.00, "102-102-102", "01-01-2020")


    val jubey = Patron("300","jubey", "simanjuntak", "jubey@gmail.com",
        "+6282209801213")
    val heri = Patron("301","heri", "saragi", "heri@gmail.com",
        "+6282210289078")
    val adi = Patron("302","adi", "sagala", "adi@gmail.com",
        "+6282189095678")

    val morris = Cat("100", "Morris", "M", "1", "Tabby Tomcat")
    val orangey = Cat("101", "Orangey", "M", "1", "Toyger")
    val lewis = Cat("102", "Lewis Carol", "M", "2", "CHESHIRE")
    val choupette = Cat("103", "Choupette", "F", "2", "Birman")


    val sponsorshipOne = Sponsorship("300", "100")
    val sponsorshipTwo = Sponsorship("300", "101")
    val sponsorshipThree = Sponsorship("301", "102")
    val sponsorshipFour = Sponsorship("302", "103")

    val brewedCoffe = Product("50A", "Brewed Cofee", 5.25)
    val cappucino = Product("51A", "Cappucino", 4.50)
    val coldBrew = Product("52A", "Cold Brew", 5.25)
    val americano = Product("53A", "Americano", 3.50)
    val chaiLatte = Product("54A", "Chai Latte", 5.75)
    val mocha = Product("55A", "Mocha", 4.75)
    val latte = Product("56A", "Latte", 4.75)
    val espresso = Product("57A", "Espresso", 2.75)
    val macchiato = Product("58A", "Macchiato", 2.25)


    cafeController.sellItems(listOf(brewedCoffe), "300", 1.17, 1.63)

}