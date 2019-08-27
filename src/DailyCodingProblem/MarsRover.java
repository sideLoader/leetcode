package DailyCodingProblem;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Position {
    int x;
    int y;
    Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}

enum Direction {
    NORTH(0, "N"),
    SOUTH(2, "S"),
    EAST(1, "E"),
    WEST(3, "W");

    int value;
    String str;

    Direction(int value, String str) {
        this.str = str;
        this.value = value;
    }

    static Map<Integer, Direction> map = new HashMap<>();
    static Map<String, Direction> mapStr = new HashMap<>();
    static {
        for(Direction direction : Direction.values())
            map.put(direction.value, direction);

        for(Direction direction : Direction.values())
            mapStr.put(direction.str, direction);
    }

    static Direction lookupInt(Integer key) {
        return map.get(key);
    }

    static Direction lookupStr(String key) {
        return mapStr.get(key);
    }
}

enum Command {
    LEFT("L"),
    RIGHT("R"),
    MOVE("M");

    String value;
    Command(String value) {
        this.value = value;
    }

    static Map<String, Command> map = new HashMap<>();
    static {
        for(Command command : Command.values())
            map.put(command.value, command);
    }

    static Command lookup(String key) {
        return map.get(key);
    }
}

public class MarsRover {

    static int M,N;

    private static Position turnLeft(Position position) {
        int oldDirection = position.direction.value -1;
        if(oldDirection < 0)
            oldDirection = 3;

        Direction newDirection = Direction.lookupInt(oldDirection);

        return new Position(position.x, position.y, newDirection);
    }

    private static Position turnRight(Position position) {
        int oldDirection = position.direction.value +1;
        if(oldDirection > 3)
            oldDirection = 0;

        Direction newDirection = Direction.lookupInt(oldDirection);

        return new Position(position.x, position.y, newDirection);
    }

    private static Position move(Position position) {
        Direction direction = position.direction;
        Position result = position;
        switch(direction) {
            case NORTH:
                result = new Position(position.x, position.y +1, direction);
                break;
            case EAST:
                result = new Position(position.x +1, position.y, direction);
                break;
            case SOUTH:
                result = new Position(position.x, position.y -1, direction);
                break;
            case WEST:
                result = new Position(position.x -1, position.y, direction);
                break;
            default:
                break;
        }

        return result;
    }

    private static void executeCommands(Position position, String commands) {

        for(char command : commands.toCharArray()) {
            Command commandEnum = Command.lookup(String.valueOf(command));

            switch(commandEnum) {
                case LEFT:
                    position = turnLeft(position);
                    break;
                case RIGHT:
                    position = turnRight(position);
                    break;
                case MOVE:
                    position = move(position);
                    break;
                default:
                    break;
            }
        }

        System.out.println(position.x + " " + position.y + " " + position.direction.str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int t = sc.nextInt();
        while(t > 0) {

            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();

            String direction = sc.nextLine().trim();
            String commands = sc.nextLine();

            executeCommands(new Position(x, y, Direction.lookupStr(direction)), commands);
            t--;
        }

    }
}
