class ChatUser extends Thread {

    private boolean suspended = false;
    private boolean stopped = false;

    ChatUser(String name) {
        super(name);
    }

    public void run() {

        try {

            for (int i = 1; i <= 5; i++) {

                synchronized (this) {

                    while (suspended) {
                        wait();
                    }
                }

                if (stopped)
                    break;

                System.out.println(getName() + " : Message " + i);

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(getName() + " chat ended");
    }

    synchronized void suspendThread() {
        suspended = true;
    }

    synchronized void resumeThread() {
        suspended = false;
        notify();
    }

    synchronized void stopThread() {
        stopped = true;
    }
}

public class ChatSystem {

    public static void main(String[] args) {

        ChatUser user1 = new ChatUser("Alice");
        ChatUser user2 = new ChatUser("Bob");

        user1.setPriority(Thread.MAX_PRIORITY);
        user2.setPriority(Thread.MIN_PRIORITY);

        user1.start();
        user2.start();

        System.out.println("User1 Alive: " + user1.isAlive());
        System.out.println("User2 Alive: " + user2.isAlive());

        try {

            Thread.sleep(3000);

            user2.suspendThread();
            System.out.println("Bob Suspended");

            Thread.sleep(3000);

            user2.resumeThread();
            System.out.println("Bob Resumed");

            Thread.sleep(3000);

            user1.stopThread();
            System.out.println("Alice Stopped");

            user1.join();
            user2.join();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Chat System Ended");
    }
}
