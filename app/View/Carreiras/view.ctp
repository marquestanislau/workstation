<div class="carreiras view">
<h2><?php echo __('Carreira'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($carreira['Carreira']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($carreira['Carreira']['nome']); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Carreira'), array('action' => 'edit', $carreira['Carreira']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Carreira'), array('action' => 'delete', $carreira['Carreira']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $carreira['Carreira']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('action' => 'add')); ?> </li>
	</ul>
</div>
