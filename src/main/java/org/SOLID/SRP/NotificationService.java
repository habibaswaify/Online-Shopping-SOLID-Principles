package org.SOLID.SRP;

    import org.SOLID.OCP.INotifier;

    import java.util.List;
// Single Responsibility Principle Application: Separate class to notify customers
    public class NotificationService {
        private final List<INotifier> notifiers;

        public NotificationService(List<INotifier> notifiers) {
            this.notifiers = notifiers;
        }

        public void notifyCustomer() {
            for (INotifier notifier : notifiers) {
                notifier.notifyCustomer();
            }
        }
    }

