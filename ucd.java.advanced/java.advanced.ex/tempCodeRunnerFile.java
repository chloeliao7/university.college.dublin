     class Synch {
          	int i;
          	synchronized void go() {
          		Synch s = new Synch();
          		synchronized (this) {}
          		synchronized (s) {}
          	}
          }