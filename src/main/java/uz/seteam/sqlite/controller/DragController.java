package uz.seteam.sqlite.controller;

import uz.seteam.sqlite.entity.Drag;
import uz.seteam.sqlite.repostroy.DragRepositroy;

import java.util.Scanner;

public class DragController extends DragRepositroy {
    private Scanner scanner = new Scanner(System.in);
    public  void isWorkingDrag(){
        boolean stop = true;
        while (stop){
            System.out.println("<<   Drag blog    >>");
            System.out.println("====================");
            System.out.println("====================");
            System.out.println("1- All drags list");
            System.out.println("2- Create drag");
            System.out.println("3- Update");
            System.out.println("4- Delete");
            System.out.println("5- Get drag by id");
            System.out.println("6- Back to home ");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(getAllDrags());
                    break;
                case 2:
                    madeDrug();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    readOneDrag();
                    break;
                case 6:
                    stop = false;
                    break;
            }
        }

    }

    private void readOneDrag() {
        System.out.println("   Read one drags  ");
        System.out.println("=====================");
        System.out.println(getAllDrags());
        System.out.println("Input id which you see");
        Long id = scanner.nextLong();
        System.out.println(getDragById(id));
    }

    private void remove() {
        System.out.println("<<   Remove drag by id   >>");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println(" Input id which you remove ");
        Long idForRemoveDrug = scanner.nextLong();
        delete(idForRemoveDrug);

    }

    private void update() {
        System.out.println("  Update drag  ");
        System.out.println("===============");
        System.out.println("===============");
        System.out.println(getAllDrags());
        System.out.println("Type id Drag");
        Long idDrag = scanner.nextLong();
        System.out.println(getDragById(idDrag));
        System.out.println("Input drag name");
        String dragName = scanner.next();
        System.out.println("Input drag cost");
        Integer dragCost = scanner.nextInt();
        System.out.println("Input drag count");
        Integer dragCount = scanner.nextInt();
        System.out.println("Input Date");
        String dateForDragBuy = scanner.next();
        Integer generalCost = dragCost * dragCount;
        Drag updateDragById = new Drag(dragName, dragCost, dragCount, dateForDragBuy,generalCost, (long) 3);
        updateDragById.setId(idDrag);
        ubdate(updateDragById);

    }

    private void madeDrug() {
        System.out.println("<<   Create drag   >>");
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("Input drag name");
        String dragName = scanner.next();
        System.out.println("Input drag cost");
        Integer dragCost = scanner.nextInt();
        System.out.println("Input drag count");
        Integer dragCount = scanner.nextInt();
        System.out.println("Input Date");
        String dateForDragBuy = scanner.next();
        Integer generalCost = dragCost * dragCount;
        Drag newDrag = new Drag(dragName, dragCost, dragCount, dateForDragBuy,generalCost, (long) 3);
        createDrug(newDrag);
    }
}
