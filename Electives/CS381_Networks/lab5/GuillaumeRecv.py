# FILL IN HEADER COMMENTS

import socket

MAXFILES = 3 # receive at most this many files
MAXBLOCKS = 1000 # files can't exceed 1000 * 1024 bytes
SERVERTIMEOUT = 30 # after 30 seconds with no requests, shut down server

# Create a server socket that listens for files:
sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sock.bind(('',12345))
sock.listen(1)
sock.settimeout(SERVERTIMEOUT)

try: # We handle a server socket timeout at the "except:" line

  for filenum in range(MAXFILES):

    connection,addr = sock.accept()
    print "DEBUG: connected to" + str(addr)
    connection.settimeout(1)

    # Receive the "PUT" message, extract filename and filesize


    message = connection.recv(1024)
    #print "received PUT message"
    message = message.split(" ")
    filename = str(message[1])
    #print filename
    filesize = message[2]
    #print "filename and filesize extracted and saved"
    print "DEBUG: received request PUT "+str(filename)+" "+str(filesize)

    #print "sending ok message" 
    connection.send('OK')
    #print "sent ok message"

    # Create a new file:
    f = open('_'+filename,'wb')
    print "DEBUG: Saving "+filename+" in _"+filename
    #GOT THIS FAR IN OUTPUT

    i = 0
    try: # We handle a connection timeout at the "except:" line

      while i <= filesize: 

        block = connection.recv(1024)
        i = i + len(block)
        #print "received block of size " + str(len(block))

        if len(block) == 0: # this happens when client closes socket
          break
        f.write(block)
        connection.send('OK Recieved '+str(i)+' bytes')
        #print "sent recieved message for x bytes"

      # No more data--close file and close connection
      f.close()
      connection.close()
      print "DEBUG: successfully recieved "+str(i)+" bytes"

    except socket.timeout: # connection is still open but no data arriving
        print "connection timed out"
        f.close()
        connection.close()


    except socket.timeout: # This shouldn't happen!
      print "DEBUG: connection timed out (this shouldn't happen!)"
      f.close()
      connection.close()

  sock.close() # Close after MAXFILES files have been received

except socket.timeout:
  print "DEBUG: listener timed out"
  sock.close()
