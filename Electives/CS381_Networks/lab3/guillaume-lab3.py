# SJ Guillaume
# Honor Code: This work is my own.
# Lab 3 Due February 18

# We need the time package to calculate round-trip times:
import time
import socket

from socket import *


# Create UDP client socket
# Note the use of SOCK_DGRAM for UDP datagram packet
clientsocket = socket(AF_INET, SOCK_DGRAM)
print 'client socket created'

host = 'localhost'
port = 12345
timeout = 5.0 # in seconds
trials = 0
grandsum = 0
number = 1
# Set socket timeout as 1 second
clientsocket.settimeout(timeout)    #sets socket to timeout after "timeout" seconds have passed

# Ping 10 times:
for i in range(1,11):
	message = raw_input('Enter message: ')
	try:
		#send the whole string
		print "Sending message: "
		# Save current time (this is the start time):
		time1 = time.clock()
		# Send the UDP packet containing the ping message
		clientsocket.sendto(message, (host, port))
		#Receive the server response
		response = clientsocket.recvfrom(1024)
		reply = response[0]
		addr = response[1]
		# Save current time (this is the end time)
		time2 = time.clock()
		# Display the server response as an output
		print 'Server response ' + reply
		# print round trip time (difference between end time and start time):
		timetotal = time2 - time1
		print timetotal
		grandsum = grandsum + timetotal
		trials= trials + 1
		number = number +1
		
		continue
	except error:
        	# Server does not respond; assume packet is lost and print message:
        	print 'Server timed out, packet is lost: ' + message
		number = number +1
        	continue
average = grandsum/trials
print 'The average runtime is: ' 
print average
print 'Number of successful pings: '
print trials 
print 'Number of unsuccessful pings: '
print (10-trials)
# Close the client socket
clientsocket.close()
