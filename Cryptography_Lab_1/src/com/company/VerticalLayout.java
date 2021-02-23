package com.company;

import java.awt.*;

// Менеджер вертикального расположения компонентов
class VerticalLayout implements LayoutManager
{
    private Dimension size = new Dimension();

    // Следующие два метода не используются
    public void addLayoutComponent   (String name, Component comp) {}
    public void removeLayoutComponent(Component comp) {}

    // Метод определения минимального размера для контейнера
    public Dimension minimumLayoutSize(Container c) {
        return calculateBestSize(c);
    }
    // Метод определения предпочтительного размера для контейнера
    public Dimension preferredLayoutSize(Container c) {
        return calculateBestSize(c);
    }
    // Метод расположения компонентов в контейнере
    public void layoutContainer(Container container)
    {
        // Список компонентов
        Component[] list = container.getComponents();
        int currentY = 5;
        for (Component component : list) {
            // Определение предпочтительного размера компонента
            Dimension pref = component.getPreferredSize();
            // Размещение компонента на экране
            component.setBounds(5, currentY, pref.width, pref.height);
            // Учитываем промежуток в 5 пикселов
            currentY += 5;
            // Смещаем вертикальную позицию компонента
            currentY += pref.height;
        }
    }
    // Метод вычисления оптимального размера контейнера
    private Dimension calculateBestSize(Container c)
    {
        // Вычисление длины контейнера
        Component[] list = c.getComponents();
        int maxWidth = 0;
        for (Component component : list) {
            int width = component.getWidth();
            // Поиск компонента с максимальной длиной
            if (width > maxWidth)
                maxWidth = width;
        }
        // Размер контейнера в длину с учетом левого отступа
        size.width = maxWidth ;
        // Вычисление высоты контейнера
        int height = 0;
        for (Component component : list) {
            height += 5;
            height += component.getHeight();
        }
        size.height = height;
        return size;
    }
}