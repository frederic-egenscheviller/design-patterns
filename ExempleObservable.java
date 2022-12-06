public class ExempleObservable extends Application {
    private final BooleanProperty overTen = new SimpleBooleanProperty(false);
    private final IntegerProperty counter = new SimpleIntegerProperty(7);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        overTen.bind(counter.greaterThan(10));
        overTen.addListener(ob -> System.out.println("Boolean invalid " + counter.getValue()));
        counter.addListener(ob -> System.out.println("Counter Invalid: " + counter.getValue()));
        Scene scene = new Scene(createContent(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    private Region createContent() {
        Button button = new Button("Click Me!");
        button.setOnAction(evt -> {
            System.out.println("Button Clicked");
            counter.set(counter.getValue() + 1);
        });
        VBox vBox = new VBox(button);
        vBox.setPadding(new Insets(30));
        return vBox;
    }
}