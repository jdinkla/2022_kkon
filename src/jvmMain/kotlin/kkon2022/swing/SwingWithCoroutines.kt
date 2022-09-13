package kkon2022.swing

import kkon2022.ui.Counter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.swing.Swing
import java.awt.Font
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.border.EmptyBorder

class ExampleApp : ActionListener {
    private val frame: JFrame = JFrame()
    private val startButton = JButton()
    private val stopButton = JButton()
    private val statusText = JTextField()
    private val counter = Counter(Dispatchers.Swing) { statusText.text = "$it" }

    init {
        with(frame) {
            with(startButton) {
                text = "Start"
                isEnabled = true
                addActionListener {
                    println("Start coroutine")
                    startButton.isEnabled = false
                    stopButton.isEnabled = true
                    counter.start()
                }
            }
            with(stopButton) {
                text = "Stop coroutine"
                isEnabled = false
                addActionListener {
                    println("Stop")
                    startButton.isEnabled = true
                    stopButton.isEnabled = false
                    counter.cancel()
                    statusText.text = ""
                }
            }

            title = "Coroutines with Swing"
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            jMenuBar = createMenuBar(this@ExampleApp)
            setSize(480, 270)

            val buttons = JPanel().apply {
                layout = BoxLayout(this, BoxLayout.X_AXIS)
                border = EmptyBorder(10, 10, 10, 10)
                add(startButton)
                add(stopButton)
            }
            with(statusText) {
                text = ""
                horizontalAlignment = JTextField.CENTER
                isEditable = false
                setFont(Font("Arial Black", Font.BOLD, 42))
            }
            add(JPanel().apply {
                layout = BoxLayout(this, BoxLayout.Y_AXIS)
                add(buttons)
                add(statusText)
            })
            isVisible = true
        }
    }

    override fun actionPerformed(e: ActionEvent) {
        when (e.actionCommand) {
            "About" -> about(frame)
            "Quit" -> quit(frame)
            else -> throw RuntimeException("Unknown Command")
        }
    }
}

private fun about(frame: JFrame) {
    println("about")
    JOptionPane.showMessageDialog(
        frame,
        "This is an example application that shows how to use coroutines with Swing.",
        "About this app",
        JOptionPane.PLAIN_MESSAGE
    )
}

private fun quit(frame: JFrame) {
    val choice = JOptionPane.showOptionDialog(
        frame,
        "Do you really want to quit?",
        "Quit",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, null, null
    )
    if (choice == 0) {
        System.exit(0)
    }
}

private fun createMenuBar(parent: ActionListener): JMenuBar {
    return JMenuBar().apply {
        add(JMenu("File").apply {
            mnemonic = KeyEvent.VK_F
            addSeparator()
            add(JMenuItem("Quit").apply {
                mnemonic = KeyEvent.VK_Q
                addActionListener(parent)
            })
        })
        add(JMenu("Help").apply {
            mnemonic = KeyEvent.VK_H
            add(JMenuItem("About").apply {
                mnemonic = KeyEvent.VK_A
                addActionListener(parent)
            })
        })
    }
}

fun main() {
    ExampleApp()
}
