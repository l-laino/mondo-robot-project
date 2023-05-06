package handlers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    private int code;
    private boolean up, down, left, right, pressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

	@Override			// QUESTO ERRORE NON CAPISCO COME RISOLVERLO .......
    public void KeyPressed(KeyEvent e) {
        setCode(e.getKeyCode());

        if ((getCode() == KeyEvent.VK_W || getCode() == KeyEvent.VK_UP) && isPressed() == false) {
			setUp(true);
			setPressed(true);
		}
		if ((getCode() == KeyEvent.VK_S || getCode() == KeyEvent.VK_DOWN) && isPressed() == false) {
			setDown(true);
			setPressed(true);
		}
		if ((getCode() == KeyEvent.VK_A || getCode() == KeyEvent.VK_LEFT) && isPressed() == false) {
			setLeft(true);
			setPressed(true);
		}
		if ((getCode() == KeyEvent.VK_D || getCode() == KeyEvent.VK_RIGHT) && isPressed() == false) {
			setRight(true);
			setPressed(true);
		}
    }

    @Override
	public void keyReleased(KeyEvent e) {
		setCode(e.getKeyCode());
		if ((getCode() == KeyEvent.VK_W || getCode() == KeyEvent.VK_UP) && (isUp())) {
			setUp(false);
			setPressed(false);
		}
		if ((getCode() == KeyEvent.VK_S || getCode() == KeyEvent.VK_DOWN) && (isDown())) {
			setDown(false);
			setPressed(false);
		}
		if ((getCode() == KeyEvent.VK_A || getCode() == KeyEvent.VK_LEFT) && (isLeft())) {
			setLeft(false);
			setPressed(false);
		}
		if ((getCode() == KeyEvent.VK_D || getCode() == KeyEvent.VK_RIGHT) && (isRight())) {
			setRight(false);
			setPressed(false);
		}
	}

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isUp1() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
}
