package myawt;
import java.awt.*;
import java.awt.event.*;

public class PractiseHotel {

    public static void main(String[] args) {
        Frame frame = new Frame("Hotel Booking System");
        frame.setSize(500, 700);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Head
        Label labelhead = new Label("Hotel JAVA", Label.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        frame.add(labelhead, gbc);

        // Name
        gbc.gridwidth = 1;
        Label labelname = new Label("Name:");
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(labelname, gbc);

        TextField textname = new TextField(20);
        gbc.gridx = 1; 
        frame.add(textname, gbc);

        // Email
        Label labelemail = new Label("Email:");
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(labelemail, gbc);

        TextField textemail = new TextField(20);
        gbc.gridx = 1;
        frame.add(textemail, gbc);

        // Phone
        Label labelphone = new Label("Phone:");
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(labelphone, gbc);

        TextField textphone = new TextField(20);
        gbc.gridx = 1;
        frame.add(textphone, gbc);

        // Room Type
        Label labelroom = new Label("Room Type:");
        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(labelroom, gbc);

        Choice room = new Choice();
        room.add("Single Room");
        room.add("Double Room");
        room.add("Suite");
        gbc.gridx = 1;
        frame.add(room, gbc);

        // Amenities
        Label labelamenities = new Label("Amenities:");
        gbc.gridx = 0; gbc.gridy = 5;
        frame.add(labelamenities, gbc);

        Panel checkboxPanel = new Panel(new GridLayout(2, 2));
        Checkbox box1 = new Checkbox("Wifi");
        Checkbox box2 = new Checkbox("Breakfast");
        Checkbox box3 = new Checkbox("Swimming pool");
        Checkbox box4 = new Checkbox("Gym");
        checkboxPanel.add(box1);
        checkboxPanel.add(box2);
        checkboxPanel.add(box3);
        checkboxPanel.add(box4);
        gbc.gridx = 1;
        frame.add(checkboxPanel, gbc);

        // Payment Method
        Label labelpay = new Label("Payment:");
        gbc.gridx = 0; gbc.gridy = 6;
        frame.add(labelpay, gbc);

        CheckboxGroup paymentGroup = new CheckboxGroup();
        Panel radioPanel = new Panel(new GridLayout(2, 2));
        Checkbox pay1 = new Checkbox("Credit Card", paymentGroup, false);
        Checkbox pay2 = new Checkbox("Debit Card", paymentGroup, false);
        Checkbox pay3 = new Checkbox("UPI", paymentGroup, false);
        Checkbox pay4 = new Checkbox("Cash", paymentGroup, false);
        radioPanel.add(pay1);
        radioPanel.add(pay2);
        radioPanel.add(pay3);
        radioPanel.add(pay4);
        gbc.gridx = 1;
        frame.add(radioPanel, gbc);

        // Suggestion Box
        Label labeltext = new Label("Suggestions:");
        gbc.gridx = 0; gbc.gridy = 7;
        frame.add(labeltext, gbc);

        TextArea area = new TextArea(3, 20);
        gbc.gridx = 1;
        frame.add(area, gbc);

        // Buttons
        Panel buttonPanel = new Panel(new GridLayout(1, 2, 10, 0));
        Button btn1 = new Button("Book Now");
        Button btn2 = new Button("Reset");
        buttonPanel.add(btn1);
        buttonPanel.add(btn2);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        frame.add(buttonPanel, gbc);

        // Action Listeners
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = textname.getText();
                String email = textemail.getText();
                String phone = textphone.getText();
                String choice = room.getSelectedItem();
                String selected = "";

                if (box1.getState()) selected += "Wifi ";
                if (box2.getState()) selected += "Breakfast ";
                if (box3.getState()) selected += "Swimming Pool ";
                if (box4.getState()) selected += "Gym ";

                Checkbox selectedPayment = paymentGroup.getSelectedCheckbox();
                String paymentMethod = (selectedPayment != null) ? selectedPayment.getLabel() : "Not Selected";

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || paymentMethod.equals("Not Selected")) {
                    System.out.println("Error: Please Enter all the fields!");
                } else {
                    System.out.println("Booking Confirmed!");
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Phone: " + phone);
                    System.out.println("Room Type: " + choice);
                    System.out.println("Selected Amenities: " + selected);
                    System.out.println("Payment Method: " + paymentMethod);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textname.setText("");
                textemail.setText("");
                textphone.setText("");
                room.select(0);
                paymentGroup.setSelectedCheckbox(null);
                box1.setState(false);
                box2.setState(false);
                box3.setState(false);
                box4.setState(false);
                area.setText("");
            }
        });

        // Closing Behavior
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });

        // Styling
        frame.setBackground(Color.LIGHT_GRAY);
        btn1.setBackground(Color.GRAY);
        btn2.setBackground(Color.GRAY);
        frame.setVisible(true);
    }
}
