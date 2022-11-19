package view.components;

import model.MenuModel;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class MenuList<E extends  Object> extends JList<E>{
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int overIndex = -1;
    
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;     
    }
    
    public MenuList() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if(o instanceof MenuModel) {
                        MenuModel menu = (MenuModel) o;
                        if(menu.getType() == MenuModel.MenuType.MENU) {
                            selectedIndex = index;
                            if(event != null) {
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }    

            @Override
            public void mouseExited(MouseEvent e) {
                overIndex = -1; // rời khỏi menu khong để lại màu
                repaint();
            }
        });
        
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if(index != overIndex) {
                    Object o = model.getElementAt(index);
                    if(o instanceof MenuModel) {
                        MenuModel menu = (MenuModel) o;
                        if(menu.getType() == MenuModel.MenuType.MENU) {
                            overIndex = index;
                        } else {
                            overIndex = -1;
                        }
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean selected, boolean focus) {
                MenuModel data;
                if(value instanceof MenuModel) {
                    data = (MenuModel) value;
                } else {
                    data = new MenuModel(value + "", MenuModel.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            } 
        };
    }
    
    public void addItem(MenuModel data) {
        model.addElement(data);
    }
}
